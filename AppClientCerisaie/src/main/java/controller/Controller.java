package controller;

import model.Activite;
import utils.Tools;

import javax.annotation.Resource;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


@WebServlet("/Controleur")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 10L;
    private static final String ACTION_TYPE = "action";
    private static final String AJOUTER_INSCRIPTION = "ajouteInscription";
    private static final String ENVOI_INSCRIPTION = "envoiInscription";
    private static final String RETOUR_ACCUEIL = "Retour";

    /**
     * @see HttpServlet#HttpServlet()
     */

    @Resource(lookup = "java:jboss/exported/topic/CerisaieTopic")
    private Topic topic;
    // On accède à l'EJB

    @Resource(mappedName = "java:/ConnectionFactory")
    private TopicConnectionFactory cf;

    // Session établie avec le serveur
    private TopicSession session = null;

    // Le client utilise un Producteur de messsage pour envoyer une demande de
    // formation
    private TopicPublisher producer;

    /**
     * Constructeur par défaut de la classe
     */
    public Controller() {
        super();
    }

    /**
     *
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            TraiteRequete(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            TraiteRequete(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Procédure principale de démarrage
     */
    public void TraiteRequete(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // On récupère l'action
        String actionName = request.getParameter(ACTION_TYPE);

        // Si on veut afficher l'ensemble des demandes d'inscription
        if (AJOUTER_INSCRIPTION.equals(actionName)) {
            System.out.println("sdoifsdofi");
            request.setAttribute("sports", new Tools().getSports());
            request.setAttribute("activites", new Tools().getActivites());
            request.setAttribute("sejours", new Tools().getSejours());

            request.getRequestDispatcher("AjouteInscription.jsp").forward(request, response);

        } else if (RETOUR_ACCUEIL.equals(actionName)) {
            this.getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
        } else if (ENVOI_INSCRIPTION.equals(actionName)) {
            response.setContentType("text/html;charset=UTF-8");
            String codeSport = request.getParameter("codeSport");
            String numSej = request.getParameter("numSejour");
            Date dateReservation = Date.valueOf(request.getParameter("datejour"));
            String nbUnite = request.getParameter("unite");

            System.out.println(codeSport);
            if ((codeSport != null) && (numSej != null) && (dateReservation != null) && (nbUnite != null)) {
                try {

                    Activite activite = new Activite();
                    activite.setCodeSport(Integer.parseInt(codeSport));
                    activite.setNumSej(Integer.parseInt(numSej));
                    activite.setDateJour(dateReservation);
                    activite.setNbLoc(Integer.parseInt(nbUnite));


                    // On envoie cette demande d'inscription d'activite dans le topic
                    boolean ok = envoi(activite);
                    if (ok)
                        // On retourne àla page d'accueil
                        this.getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
                    else {
                        this.getServletContext().getRequestDispatcher("/Erreur.jsp").include(request, response);
                    }
                } catch (Exception m) {
                    // On passe l'erreur à  la page JSP
                    request.setAttribute("MesErreurs", m.getMessage());
                    request.getRequestDispatcher("PostMessage.jsp").forward(request, response);
                }
            }
        }
    }

    /**
     * Permet de publier une demande d'inscription dans le topic
     *
     * @param activite La demande d'inscription � publier
     * @return
     * @throws Exception
     */
    private boolean envoi(Activite activite) throws Exception {

        boolean ok = true;
        TopicConnection connection = null;

        try {
            connection = cf.createTopicConnection();
            session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

            // On crée le producteur utilisé pour envoyer un message
            producer = session.createPublisher(topic);
            // On lance la connection
            connection.start();
            ObjectMessage message = session.createObjectMessage();
            message.setObject(activite);
            // On publie le message
            producer.publish(message);
            producer.close();
            session.close();
            connection.close();
        } catch (JMSException j) {
            new Exception(j.getMessage());
            ok = false;
        } catch (Exception e) {
            new Exception(e.getMessage());
            ok = false;
        }
        return ok;
    }

}