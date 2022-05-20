<%@page import="java.util.List"%>
<%@page import="database.User"%>
<%@page import="database.User"%>
<%@page import="database.UserManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="headerAdmin.jsp" %>

<!--   Display users   -->
<style>

</style>
<script>

</script>
<div class="container-fluid pt-4 px-4">
    <div class="row bg-light  rounded align-items-center justify-content-center mx-0" id="display-search">
        <div class="bg-light rounded h-100 p-4">
            <h6 class="mb-4">Responsive Table</h6>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">User Name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Password</th>
                            <th scope="col">Phone Number</th>
                            <th scope="col">Credit Limit</th>
                            <th scope="col">Delete</th>
                            <th scope="col">Edit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<User> users = UserManager.getAllUsers();
                            for (User user : users) {%>
                        <tr>
                            <th scope="row"><%=user.getUserId()%></th>
                            <td><%=user.getName()%></td>
                            <td><%=user.getEmail()%></td>
                            <td><%=user.getPassword()%></td>
                            <td><%=user.getPhone()%></td>
                            <td><%=user.getCreditLimit()%></td>
                            <td> <button type="button" class="btn btn-danger rounded-pill m-2">Delete</button></td>
                            <td> <button type="button" class="btn btn-info rounded-pill m-2">Edit</button></td>
                        </tr>

                        <% }%>


                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%@ include file="footerAdmin.jsp" %>

