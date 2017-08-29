<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%
    String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>ActiveMQ HomePage</title>
</head>
<body>
<h1>Spring JmsTemplate</h1>
<h2>Queue</h2>
<h3><a href="<%=contextPath%>/onsend?type=queue">Send Queue Message</a></h3>
<%--<h3><a href="<%=contextPath%>/queuereceive">Receive Queue Message</a></h3>--%>
<h2>Topic</h2>
<h3><a href="<%=contextPath%>/onsend?type=topic">Send Topic Message</a></h3>
<%--<h3><a href="<%=contextPath%>/topicreceive">Receive Topic Message</a></h3>--%>
<h1>非Spring JmsTemplate</h1>
<h2>JMS公共</h2>
<h3><a href="<%=contextPath%>/jmssend">Send JMS Message</a></h3>
<h3><a href="<%=contextPath%>/jmsreceive">Receive JMS Message</a></h3>
<h2>点对点域</h2>
<h3><a href="<%=contextPath%>/queuesend1">Send Queue Message</a></h3>
<h3><a href="<%=contextPath%>/queuereceive1">Receive Queue Message</a></h3>
<h2>发布/订阅域</h2>
<h3><a href="<%=contextPath%>/topicsend1">Send Topic Message</a></h3>
<h3><a href="<%=contextPath%>/topicreceive1">Receive Topic Message</a></h3>
<h2>request-response</h2>
<h3><a href="<%=contextPath%>/server">server</a></h3>
<h3><a href="<%=contextPath%>/client">client</a></h3>
</body>
</html>