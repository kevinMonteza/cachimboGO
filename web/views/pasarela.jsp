<%-- 
    Document   : pasarela
    Created on : Jun 23, 2018, 10:10:46 PM
    Author     : kevinMC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div>
    <ul>
        <ol>20 monedas  <span>$10</span> <input type="radio" name="valor" value="20"></ol>
        <ol>30 monedas  <span>$13</span> <input type="radio" name="valor" value="30"></ol>
        <ol>40 monedas  <span>$15</span> <input type="radio" name="valor" value="40"></ol>
    </ul>
    <table>
        <td><button class="pago" onclick="mostrar('tarjeta')">Pagar con Tarjeta</button></td>
        <td><button class="pago" onclick="mostrar('efectivo')">Pagar en efectivo</button></td>
        <td><button class="pago" onclick="mostrar('paypal')">Pagar Paypal</button></td>
    </table>
    <div id="tarjeta" style="display:none;">
        <label>Nro tarjeta</label><input type="text" name="codigo" class="form-control" placeholder="codigo" aria-describedby="sizing-addon1" required/>
        <label>Caducidad</label><input type="text" name="codigo" class="form-control" placeholder="codigo" aria-describedby="sizing-addon1" required/>
        <label>Codigo CVV</label><input type="text" name="codigo" class="form-control" placeholder="Codigo CVV" aria-describedby="sizing-addon1" required/>
        <label>Titular tarjeta</label><input type="text" name="codigo" class="form-control" placeholder="titular" aria-describedby="sizing-addon1" required/>
        <label>Codigo</label><input type="password" name="codigo" class="form-control" placeholder="codigo" aria-describedby="sizing-addon1" required/>
        <button id="pagar" class="btn btn-default" onclick="pagar('CARD')">Pagar</button>
    </div>
    <div id="paypal" style="display: none;">
        <label>Correo</label><input type="email" name="codigo" class="form-control" placeholder="codigo" aria-describedby="sizing-addon1" required/>
        <label>Password</label><input type="password" name="codigo" class="form-control" placeholder="codigo" aria-describedby="sizing-addon1" required/>
        <button id="pagar" class="btn btn-default" onclick="pagar('PAYPAL')">Pagar</button>
    </div>
    
    
</div>
