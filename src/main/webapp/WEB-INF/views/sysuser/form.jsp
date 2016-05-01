<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="user FORM" />
    <c:param name="body">
        <spring:hasBindErrors name="user">
            <script type="text/javascript">
                $(document).ready(function() {
                    $("div.control-group>div.controls>.error").parent().parent().addClass("error");
                });
            </script>
        </spring:hasBindErrors>
        <form:form method="post" action="." modelAttribute="user"
            cssClass="form-horizontal">
            <fieldset>
                <legend>user</legend>
                <div class="control-group">
                    <label class="control-label" for="userName">name</label>
                    <div class="controls">
                        <form:input path="userName" cssClass="span5"
                            cssErrorClass="error" />
                        <form:errors path="userName"
                            cssClass="error help-inline inline"
                            element="span" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="password">password</label>
                    <div class="controls">
                        <form:input path="password" cssClass="span3"
                            cssErrorClass="error" />
                        <form:errors path="password"
                            cssClass="error help-inline inline"
                            element="span" />
                    </div>
                </div>
                <form:hidden path="user_id" />
                <div class="form-actions">
                    <input type="submit" class="btn btn-primary"
                        value="Submit">&nbsp;
                    <button type="reset" class="btn">Cancel</button>
                </div>
            </fieldset>
        </form:form>
        <hr>
        <a href='${pageContext.request.contextPath}/u/list' class="btn">list</a>
    </c:param>
</c:import>

