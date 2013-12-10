<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="user" class="dgwee.eSaint.User" scope="session"/>

<html><head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type"><title>List of Bidders</title></head><body>
<div style="text-align: center;">List of Bidders<br>
</div>
<br>
<div style="text-align: center;">Item ID: <input name="Item ID"><br>
</div>


<br>
<div style="text-align: center;">(<input name="Start Date"> -- <input name="End Date">)<br>
</div>
<br>
<table style="text-align: left; width: 100px; margin-left: auto; margin-right: auto;" border="1" cellpadding="2" cellspacing="2">
  <tbody>
    <tr>
      <td style="vertical-align: top;">Bidding Time<br>
      </td>
      <td style="vertical-align: top;">Username<br>
      </td>
      <td style="vertical-align: top;">Buyer Rating<br>
      </td>
      <td style="vertical-align: top;">Bidding Price<br>
      </td>
    </tr>
    <tr>
      <td style="vertical-align: top;"><br>
      </td>
      <td style="vertical-align: top;"><br>
      </td>
      <td style="vertical-align: top;"><br>
      </td>
      <td style="vertical-align: top;"><br>
      </td>
    </tr>
  </tbody>
</table>
<br>&nbsp; <br>
<table style="text-align: left; width: 100px; margin-left: auto; margin-right: auto;" border="1" cellpadding="2" cellspacing="2">
  <tbody>
    <tr>
      <td style="vertical-align: top;">Winner<br>
      </td>
      <td style="vertical-align: top;"><br>
      </td>
      <td style="vertical-align: top;"><br>
      </td>
      <td style="vertical-align: top;"><br>
      </td>
    </tr>
  </tbody>
</table>

<input name="Cancel" value="Cancel" type="submit"><br>
</body></html>
