<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="HOME" />
    <c:param name="body">
        <h2>Hello!</h2>
        <p>
            ${f:h(serverTime)} <br>
        </p>
        <ul>
            <li><a href='${pageContext.request.contextPath}/person/list/'>PERSON
                    LIST</a></li>
            <li><a href='${pageContext.request.contextPath}/person/form/'>PERSON
                    CREATE</a></li>
                     <li><a href='${pageContext.request.contextPath}/u/list/'>user
                    LIST</a></li>
            <li><a href='${pageContext.request.contextPath}/u/form/'>user
                    CREATE</a></li>
        </ul>
    </c:param>
</c:import>

