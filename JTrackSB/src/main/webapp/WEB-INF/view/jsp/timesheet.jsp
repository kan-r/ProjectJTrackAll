<%-- 
    Document   : timesheet
    Created on : 08/07/2013, 9:02:47 PM
    Author     : Kan
--%>

<%-- 
    Document   : job
    Created on : 06/07/2013, 10:02:39 PM
    Author     : Kan
--%>

<%@ include file="/WEB-INF/view/jsp/include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Timesheet</title>
    </head>
    <body>
        <div class="header-region">
            <div class="navbar">
                <div class="app-title">JTrack</div>
                <div class="app-user">Welcome: ${currentUser.firstName}</div>
                <div class="navbar-entry"><a href="<c:url value="/login?logout=true" />" >Logout</a></div>
            </div>
        </div>

        <div class="main-tabs-region">
            <ul id="tabs">
                <li class="first-non-current">
                    <a class="tab_link" href="job"><span></span>Jobs</a>
                </li>
                <li class="current">
                    <a class="tab_link" href="timesheet"><span></span>Timesheet</a>
                </li>
                <!--
                <li class="non-current">
                    <a class="tab_link" href="weeklyReport"><span></span>Reports</a>
                </li>
                -->
                <li class="non-current">
                    <a class="tab_link" href="jobType"><span></span>Admin</a>
                </li>
                <li class="last"><span></span></li>
            </ul>
        </div>
        
        <c:if test="${not empty error}">
	        <div class="container">
				<div class="alert alert-danger">${error}</div>
	        </div>
        </c:if>
                
        <div class="form-region">
	        <form:form method="POST" action="timesheet">
	                <table cellpadding="0" border="0" cellspacing="0" summary="" class="form-standard">
	                    <tr>
	                        <td>
	                            <table border="0" summary="" >
	                                <tr>
	                                    <td nowrap="nowrap" align="right">
	                                        <label>User</label>
	                                    </td>
	                                    <td  colspan="1" rowspan="1" align="left" valign="middle">
	                                        <form:select path="userId" id="userId">
	                                            <form:option value=""></form:option>
	                                            <c:forEach items="${userList}" var="user">
	                                                <form:option value="${user.userId}">${user.firstName} ${user.lastName}</form:option>
	                                            </c:forEach>
	                                        </form:select>
	                                    </td>
	                                    <td nowrap="nowrap" align="right">
	                                        <label>Worked Date From</label>
	                                    </td>
	                                    <td  colspan="1" rowspan="1" align="left" valign="middle">
	                                        <form:input path="workedDateFrom" class="date-field" />
	                                    </td>
	                                    <td nowrap="nowrap" align="right">
	                                        <label>To</label>
	                                    </td>
	                                    <td  colspan="1" rowspan="1" align="left" valign="middle">
	                                        <form:input path="workedDateTo" class="date-field" />
	                                    </td>
	                                    <td>
	                                            <input type="submit" value="Go" class="button" />
	                                    </td>
	                                </tr>
	                            </table> 
	                        </td>
	                    </tr>
	                </table>
	        </form:form> 
        </div>
        
        <div class="button-region">
            <a href="<c:url value="timesheetCreate" />" class="button">Create</a>
        </div>
        
        <div class="report-region">
            <table cellpadding="0" border="0" cellspacing="0" summary="" class="report-standard">
                <tr >
                    <th></th>
                    <th></th>
                    <th>User</th>
                    <th>Job No</th>
                    <th>Job Name</th>
                    <th>Worked Date</th>
                    <th>Worked Day</th>
                    <th>Worked Hrs</th>
                    <th>Timesheet Code</th>
                    <th>Active</th>
                    <th>Date Created</th>
                    <th>User Created</th>
                    <th>Date Modified</th>
                    <th>User Modified</th>
                </tr>
                <c:forEach items="${timesheetList}" var="timesheet">
                    <tr>
                        <td><a href="<c:url value="timesheetEdit?id=${timesheet.timesheetId}" />" >Edit</a></td>
                        <td><a href="<c:url value="timesheetDelete?id=${timesheet.timesheetId}" />" >Delete</a></td>
                        <td><c:out value="${timesheet.userObj.firstName} ${timesheet.userObj.lastName}"/></td>
                        <td><c:out value="${timesheet.jobNo}"/></td>
                        <td><c:out value="${timesheet.jobObj.jobName}"/></td>
                        <td><fmt:formatDate type="date" value="${timesheet.workedDate}"/></td>
                        <td><fmt:formatDate pattern="E" value="${timesheet.workedDate}"/></td>
                        <td><c:out value="${timesheet.workedHrs}"/></td>
                        <td><c:out value="${timesheet.timesheetCode}"/></td>
                        <c:if test="${timesheet.active}">
                        	<td align="center"><input type="checkbox" checked disabled /></td>
                        </c:if>
                        <c:if test="${!timesheet.active}">
                        	<td align="center"><input type="checkbox" disabled /></td>
                        </c:if>
                        <td><fmt:formatDate type="both" value="${timesheet.dateCrt}"/></td>
                        <td><c:out value="${timesheet.userCrtObj.firstName} ${timesheet.userCrtObj.lastName}"/></td>
                        <td><fmt:formatDate type="both" value="${timesheet.dateMod}"/></td>
                        <td><c:out value="${timesheet.userModObj.firstName} ${timesheet.userModObj.lastName}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        
    </body>
</html>
