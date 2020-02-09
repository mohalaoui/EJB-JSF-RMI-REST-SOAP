# EJB_JSF_Simple

## environnement
 version : wildfly 17.0.0.final
 download link : https://wildfly.org/downloads/

## configure h2 or other

### persistence.xml
declare a JTA data source (you can choose local ressource, in this case you have to decalre all the properties in persistence.xml)

 ```xml
<persistence-unit name="BanqueEJB" transaction-type="JTA">
		<jta-data-source>java:/dsBanque</jta-data-source>
		<class>business.entities.Account</class>
		<properties>
			<property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>
		</properties>
	</persistence-unit>
 ```

### wildfly H2 config
there is two ways :

1 - declare datasource in standalone.xml
 
 ```xml
      <datasource jndi-name="java:/dsBanque" pool-name="dsBanque">
          <connection-url>jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>
          <driver-class>org.h2.Driver</driver-class>
          <driver>h2</driver>
          <security>
              <user-name>test</user-name>
              <password>test</password>
          </security>
          <validation>
              <background-validation>false</background-validation>
          </validation>
      </datasource>
 ```
      
2 - declare datasource in wildfly config console (you hae to create an adlin user)

## RMI client
### jboss-ejb-client.properties

 ```yml
endpoint.name=client-endpoint
remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED=false
remote.connections=default
remote.connection.default.host=127.0.0.1
remote.connection.default.port = 8080  
remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS=false
remote.connection.default.username=admin
remote.connection.default.password=
 ```

## BanqueWeb
in banque web there is :
- SOAP service simple
- REST service simple
- JSF implementation simple

## Deploy to wildfly
- create a EAR projet and add banqueEJB and BanqueWEB.
- put BanqueEAR.ear in wildfly-17.0.0.Final\standalone\deployments folder
- run wildfly
