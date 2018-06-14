<%--
  Created by IntelliJ IDEA.
  User: panderium
  Date: 12/06/18
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="Header.jsp" %>
<script language="Javascript" type="text/javascript"></script>
<script type="text/javascript" src="js/foncControle.js"></script>
<script>
    function Chargement() {
        var obj = document.getElementById("id_erreur");
        if (obj.value != '')
            alert('Erreur signalée  : "' + obj.value + "'");
    }
</script>
<script src="js/js_verif.js" type="text/javascript"></script>

<form action='Controleur?action=envoiInscription' method='post' onsubmit="return verif(this);">
    <div>
        <div class="container">
            <div class="well">

                <h1>Souscrire à une activité</h1>
                <div class="form-group">
                    <label for="code_sport">Activité à réserver</label>
                    <select class="form-control" id="code_sport" name="codeSport">
                            <option value="1">Tennis</option>
                            <option value="2">VTT</option>
                            <option value="3">Planche-voile</option>
                            <option value="4">Pédalo</option>
                            <option value="5">Canoé</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="num_emplacement">Numéro de votre séjour</label>
                    <select class="form-control" id="num_emplacement" name="numSejour">
                        <option value="1">Numéro emplacement : 1</option>
                        <option value="2">Numéro emplacement : 3</option>
                        <option value="3">Numéro emplacement : 4</option>
                        <option value="4">Numéro emplacement : 2</option>
                        <option value="5">Numéro emplacement : 5</option>
                        <option value="6">Numéro emplacement : 13</option>
                        <option value="7">Numéro emplacement : 7</option>
                        <option value="8">Numéro emplacement : 8</option>
                        <option value="9">Numéro emplacement : 9</option>
                        <option value="10">Numéro emplacement : 10</option>
                        <option value="11">Numéro emplacement : 11</option>
                        <option value="12">Numéro emplacement : 12</option>
                        <option value="13">Numéro emplacement : 13</option>
                        <option value="14">Numéro emplacement : 3</option>
                        <option value="15">Numéro emplacement : 4</option>
                        <option value="16">Numéro emplacement : 5</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="datejour">Date de réservation</label>
                    <input type="text" class="form-control" name="datejour" id="datejour" value="">
                </div>
                <script>$("#datejour").datepicker({dateFormat: 'yy-mm-dd'});</script>

                <div class="form-group">
                    <label for="unite">Combien d'unité de temps</label>
                    <input type="number" class="form-control" name="unite" id="unite" min="1" value="1">
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-default btn-primary"><span
                            class="glyphicon glyphicon-ok"></span>
                        Valider
                    </button>
                    <button type="button" class="btn btn-default btn-primary"
                            onclick="{ window.location = 'index.jsp'; }">
                        <span class="glyphicon glyphicon-remove"></span> Annuler
                    </button>

                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
