<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="user" class="dgwee.eSaint.User" scope="session"/>
<html>

<head>
<title>Item Information</title>
<body>
  
<div style="text-align: center;">Item Information<br>
</div>


<br>
<table style="text-align: left; width: 382px; height: 240px;" border="1" cellpadding="2" cellspacing="2">
  <tbody>
    <tr>
      <td style="vertical-align: top;">Item ID<br>
      </td>
      <td style="vertical-align: top;"><input name="Item ID"><%= item.getItemId() %><br>
      </td>
    </tr>
    <tr>
      <td style="vertical-align: top;">Item Name<br>
      </td>
      <td style="vertical-align: top;"><input name="Item Name"><%= item.getItemName() %></td>
    </tr>
    <tr>
      <td style="vertical-align: top;">Cetegory<br>
      </td>
      <td style="vertical-align: top;"><input name="Category"><%= item.getCategory() %></td>
    </tr>
    <tr>
      <td style="vertical-align: top;">Start Price<br>
      </td>
      <td style="vertical-align: top;"><input name="Start Price"><%= item.getStartPrice() %></td>
    </tr>
    <tr>
      <td style="vertical-align: top;">Auction Starts<br>
      </td>
      <td style="vertical-align: top;"><input name="Start Day">
      <select name="Start Month">
      </select>
      <select name="Start Year">
      </select>
      <br>
      </td>
    </tr>
    <tr>
      <td style="vertical-align: top;">Auction Ends<br>
      </td>
      <td style="vertical-align: top;"><input name="End Day">
      <select name="End Month">
      </select>
      <select name="End Year">
      </select>
      <br>
      </td>
    </tr>
    <tr>
      <td style="vertical-align: top;">Description<br>
      </td>
      <td style="vertical-align: top;"><input name="Description"><%= item.getDescription() %><br>
      </td>
    </tr>
    <tr>
      <td style="vertical-align: top;">Photo<br>
      </td>
      <td style="vertical-align: top;"><input name="Photo"><%= item.getPhoto() %><br>
      </td>
    </tr>
  </tbody>
</table>
<br>
<input name="Cancel" value="Cancel" type="submit"><br>

</body>

</html>
