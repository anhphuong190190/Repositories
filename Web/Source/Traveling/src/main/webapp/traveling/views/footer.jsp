<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<footer>
  <div class="container">
    <div class="row">
      <div class="col-md-3">
        <h3><spring:message code="footer.about" /></h3>
        <p><spring:message code="footer.about.description" /></p>
      </div>
      <div class="col-md-3">
        <h3><spring:message code="footer.tweets" /></h3>
        <p>
        	<span><spring:message code="footer.tweet" /></span> 
        	<a href="<spring:message code="footer.tweet.link1" />"><spring:message code="footer.tweet.you" /></a>	        
	        <br />
          	<spring:message code="footer.tweets.description1" />
        </p>
        <p>
        	<span><spring:message code="footer.tweet" /></span> 
        	<a href="<spring:message code="footer.tweet.link2" />"><spring:message code="footer.tweet.you" /></a>
        	<br />
          	<spring:message code="footer.tweets.description2" />
      </div>
      <div class="col-md-3">
        <h3><spring:message code="footer.mail" /></h3>
        <p><spring:message code="footer.mail.description" /></p>
        <br />
        <form action="#" method="post" class="form-inline" role="form">
          <div class="form-group">
            <label class="sr-only" for="exampleInputEmail2"><spring:message code="footer.mail.input.placeholder" /></label>
            <input type="email" class="form-control form-control-lg" id="exampleInputEmail2" placeholder="<spring:message code="footer.mail.input.placeholder" />">
          </div>
          <button type="submit" class="btn btn-primary btn-md"><spring:message code="footer.mail.btn.subscribe" /></button>
        </form>
      </div>
      <div class="col-md-3">
        <h3><spring:message code="footer.social" /></h3>
        <p>
        	<spring:message code="footer.social.description" >
	        	<spring:message code="footer.social.description.street" var="street"/>
		        <spring:message code="footer.social.description.city" var="city"/>
		        <spring:message code="footer.social.description.company" var="company"/>
		        <spring:message code="footer.social.description.phone" var="phone"/>
		        <spring:message code="footer.social.description.fax" var="fax"/>
        		<spring:argument value="${street}" />
        		<spring:argument value="${city}" />
        		<spring:argument value="${company}" />
        		<spring:argument value="${phone}" />
        		<spring:argument value="${fax}" />
        	</spring:message>
          <br />
        </p>
        
        <div class="social__icons"> 
        	<a href="#" class="socialicon socialicon-twitter" ></a> 
        	<a href="#" class="socialicon socialicon-facebook" ></a> 
        	<a href="#" class="socialicon socialicon-google" ></a> 
        	<a href="#" class="socialicon socialicon-mail" ></a> 
        </div>
      </div>
    </div>
  </div>
</footer>