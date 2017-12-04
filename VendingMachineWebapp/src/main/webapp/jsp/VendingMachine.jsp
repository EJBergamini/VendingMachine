<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <title>Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">  
        <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet">
        <style>
            #map {
             height: 400px;
             width: 100%;
            }
         </style>

    </head>
    
    <header>
        <br>
        <h1 id="mainHeading">Vending Machine</h1>
        <hr>
        <br>
    </header>
    
    <body>
        <div class="container-fluid" id="theMachineUI">
            <div class="col-xs-1">
            </div>
            <div class="col-xs-6">
                <div class="row">  
                    <c:forEach var="currentItem" varStatus="loop" items="${itemList}">
                        <c:if test="${not loop.first and loop.index % 3 == 0}"> 
                            </div>
                            <div class="row" style="margin-top: 45px;">
                        </c:if>
                        <div class="col-xs-12 col-md-4 productBox">
                            <a href="getItemSelection?itemSelected=${currentItem.itemLocation}">    
                                <div class="boxBorder">
                                    <p class="productNumber"><c:out value="${currentItem.itemLocation}"/></p>
                                    <h4 class="productName"><c:out value="${currentItem.itemName}"/></h4>
                                    <br>
                                    <br>
                                    <h4 class="productCost"><c:out value="${currentItem.itemCost}"/></h4>
                                    <br>
                                    <br>
                                    <h4 class="productQuantity"><c:out value="${currentItem.numberOfItems}"/></h4>
                                    <br>
                                </div>
                            </a>        
                        </div>
                    </c:forEach>
                </div>       
            </div>
            <div class="col-xs-1">
            </div>
            <div class="col-xs-4">
                    <div class="row">
                        <div class="col-xs-12 sidebarCenter">
                            <form class="sidebarBorder" id="moneyIn">
                                <h3>Total $ In:</h3>
                                <p class="moneyInDisplay"><span  id="moneyInDisplay">$<c:out value="${moneyInDisplay}"/></span></p>                               
                                <div class="buttonSpacing">
                                    <a href="addUserMoney?money=1.00"><button class="button1" type="button" id="addDollar">Add $1.00</button></a>
                                    <a href="addUserMoney?money=0.25"><button class="button1" type="button" id="addQuarter">Add $0.25</button></a>
                                </div>
                                <div class="buttonSpacing">
                                    <a href="addUserMoney?money=0.10"><button class="button1" type="button" id="addDime">Add $0.10</button></a>
                                    <a href="addUserMoney?money=0.05"><button class="button1" type="button" id="addnickel">Add $0.05</button></a>
                                </div>
                                <br>
                            </form>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-xs-12 sidebarCenter">
                            <form class="sidebarBorder" id="messagesOut">
                                <h3>Messages:</h3>
                                <p class="display"><span id="messagesOutDisplay"><c:out value="${messagesOutDisplay}"/></span></p>
                                <br>
                                <div>
                                    <p>Item Number: <span id="item"><c:out value="${itemNumberOutput}"/></span></p>
                                </div>
                                <div>
                                    <a href="makeAPurchase?itemSelected=${itemNumberOutput}"><button class="button" type="button" id="makePurchase">Make Purchase</button></a>
                                </div>
                                <br>
                            </form>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-xs-12 sidebarCenter">
                            <form class="sidebarBorder" id="changeOut">
                                <h3>Change:</h3>
                                <p class="moneyOutDisplay" id="moneyOut">
                                    <span><c:out value="${param.dollar}"/><c:out value="${param.quarter}"/></span>
                                    <br>
                                    <span><c:out value="${param.dime}"/><c:out value="${param.nickel}"/></span>
                                </p>
                                <br>
                                <div class="buttonSpacing">
                                    <a href="makeChange"><button id="changeReturn" type="button">Change Return</button></a>
                                </div>
                                <br>
                            </form>
                        </div>
                    </div>
            </div>
        </div>
  </body>


    <footer>
    </footer>

</html>