package bean;

import Service.EnregistrerInscription;
import model.Activite;
import model.ActiviteEntity;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(
                propertyName = "destination",
                propertyValue = "java:jboss/exported/topic/CerisaieTopic"),
        @ActivationConfigProperty(
                propertyName = "destinationType",
                propertyValue = "javax.jms.Topic")
},
        mappedName = "CerisaieTopic")
public class DemandeInscriptionTopic implements MessageListener {

    @Resource
    private MessageDrivenContext context;

    public DemandeInscriptionTopic() {

    }

    public void onMessage(Message message) {
        boolean ok = false;
        // On gère le message récupéré dans le topic
        try {
            // On transforme le message en demande d'inscription
            if (message != null) {
                ObjectMessage objectMessage = (ObjectMessage) message;
                Activite activite = (Activite) objectMessage.getObject();
                try {
                    // on construit un objet Entity
                    ActiviteEntity activiteEntity = new ActiviteEntity();
                    // on tansfère les données reçues dans l'objet Entity
                    activiteEntity.setCodeSport(activite.getCodeSport());
                    activiteEntity.setDateJour(activite.getDateJour());
                    activiteEntity.setNbLoc(activite.getNbLoc());
                    activiteEntity.setNumSej(activite.getNumSej());
                    System.out.println(activite);
                    EnregistrerInscription service = new EnregistrerInscription();
                    if(activite != null)
                        service.insert(activiteEntity);
                } catch (NamingException er) {
                    EcritureErreur(er.getMessage());
                } catch (Exception e) {
                    EcritureErreur(e.getMessage());
                }
            }

        } catch (JMSException jmse) {
            System.out.println(jmse.getMessage());
            EcritureErreur(jmse.getMessage());
            context.setRollbackOnly();
        }
    }

    public void EcritureErreur(String message) {
        BufferedWriter wr;
        String nomf = "erreurs.log";
        Date madate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm");
        try {
            // On écrit à la fin du fichier
            wr = new BufferedWriter(new FileWriter(nomf, true));
            wr.newLine();
            wr.write(sdf.format(madate));
            wr.newLine();
            wr.write(message);
            wr.close();
        } catch (Exception e) {

        }
    }
}
