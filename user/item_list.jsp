<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="user" class="dgwee.eSaint.User" scope="session"/>

<html><head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type"><title>Item List</title></head><body><br>
<div style="text-align: center;">Item List<br>
</div>
<br>
<table style="text-align: left; width: 997px; height: 60px; margin-left: auto; margin-right: auto;" border="1" cellpadding="2" cellspacing="2">
  <tbody>
    <tr>
      <td style="vertical-align: top; text-align: left;">Item ID<br>
      </td>
      <td style="vertical-align: top;">Item Name<br>
      </td>
      <td style="vertical-align: top;">Category<br>
      </td>
      <td style="vertical-align: top;">Auctino Start Time<br>
      </td>
      <td style="vertical-align: top;">Auction End Time<br>
      </td>
      <td style="vertical-align: top;">Start Price<br>
      </td>
      <td style="vertical-align: top;">Current Bid<br>
      </td>
      <td style="vertical-align: top;">Status<br>
      </td>
      <td style="vertical-align: top;">Item Information<br>
      </td>
      <td style="vertical-align: top;">Bidder List<br>
      </td>
      <td style="vertical-align: top;">Rate Buyer<br>
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
      <td style="vertical-align: top;"><br>
      </td>
      <td style="vertical-align: top;"><br>
      </td>
      <td style="vertical-align: top;"><br>
      </td>
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
<br>
<div style="text-align: center;"><input name="Return to Main Page" value="Return to Main Page" type="submit"><br>
</div>


</body></html>
