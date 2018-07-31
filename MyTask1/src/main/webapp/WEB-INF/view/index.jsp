<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Christmas present</h2>
<c:forEach var="sweet" items="${requestScope.sweets}">
    <ul>
        <h4>${sweet}</h4>
        <li>Cost - <c:out value="${sweet.cost}"/></li>
        <li>Weight - <c:out value="${sweet.weight}"/></li>
        <li>Sugar - <c:out value="${sweet.sugar}"/></li>
    </ul>
</c:forEach>
<h5>Present's full weight <c:out value="${requestScope.weight}"/> </h5>
<div>
    <h3>Sort sweets by:</h3>
    <form method="get" action="/present">
        <input type="radio" name="sortType" value="cost"/> <label>Cost</label><br/>
        <input type="radio" name="sortType" value="weight"/> <label>Weight</label><br/>
        <input type="radio" name="sortType" value="sugar"/> <label>Sugar</label><br/>
        <input type="submit" value="Sort">
    </form>
</div>
<div>
    <h3>Find sweets by sugar</h3>
    <form action="/present" method="get">
        <label>from</label><input type="number" name="minSugar"/>
        <label>to</label><input type="number" name="maxSugar"/><br/>
        <input type="submit" value="Find"/>
    </form>
</div>
<div>
    <h3>Add a new sweet to the present</h3>
    <form action="/present" method="post">
        <p>Sweet type:</p>
        <input type="radio" name="sweetType" value="candy"/> <label>Candy</label><br/>
        <input type="radio" name="sweetType" value="chocolate"/> <label>Chocolate</label><br/>
        <input type="radio" name="sweetType" value="cookie"/> <label>Cookie</label><br/><br/>

        <input type="number" name="cost" placeholder="Cost"/><br/><br/>
        <input type="number" name="weight" placeholder="Weight"/><br/><br/>
        <input type="number" name="sugar" placeholder="Sugar"/><br/><br/>

        <input type="submit" value="Add">
    </form>
</div>
</body>
</html>
