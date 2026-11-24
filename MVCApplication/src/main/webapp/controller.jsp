<jsp:useBean id="person" class="com.syrine.mvcapplication.model.Person" scope="request" />
<jsp:setProperty name="person" property="*" />
<%
    String birthDay = person.getBirthDay();
    int year = Integer.parseInt(birthDay.substring(0, 4));
    if (year < 1990) {
%>
<jsp:forward page="old.jsp" />
<%
} else {
%>
<jsp:forward page="young.jsp" />
<%
    }
%>