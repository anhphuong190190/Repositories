<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<header class="main__header">
	<div class="container">
		<nav class="navbar navbar-default" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="navbar-header">
				<h1 class="navbar-brand">
					<a href="home.jsp"><spring:message code="header.logo.text1" /><span><spring:message code="header.logo.text2" /></span></a>
				</h1>
				<a href="#" onClick="javascript.void()" class="submenu"><spring:message code="header.menus" /></a>
			</div>
			<div class="menuBar">
				<ul class="menu">					
					<li class="${(param.content == 'home-content.jsp')? 'active' : ''}"><a href="home.jsp"><spring:message code="header.nav.home" /></a></li>
					<li class="${(param.content == 'blog-new-content.jsp')? 'active' : ''}"><a href="blog-new.jsp"><spring:message code="header.nav.blog" /></a></li>
					<li class="${(param.content == 'web-store-content.jsp')? 'active' : ''}"><a href="web-store.jsp"><spring:message code="header.nav.store" /></a></li>
					<li class="dropdown ${(param.content == 'portfolio-content.jsp'||param.content == 'typography-content.jsp')? 'active' : ''}"><a href="#"><spring:message code="header.nav.pages" /></a>
						<ul>							
							<li><a style="color: #2a2a2a;" href="portfolio.jsp"><spring:message code="header.nav.portfolio" /></a></li>
							<li><a style="color: #2a2a2a;" href="typography.jsp"><spring:message code="header.nav.typography" /></a></li>							
						</ul>
					</li>
					<li class="${(param.content == 'faq-content.jsp')? 'active' : ''}"><a href="faq.jsp"><spring:message code="header.nav.faq" /></a></li>
					<li class="${(param.content == 'contact-content.jsp')? 'active' : ''}"><a href="contact.jsp"><spring:message code="header.nav.contactUs" /></a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>
	</div>
</header>