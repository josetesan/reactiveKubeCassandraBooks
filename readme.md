# HOW TO
 
1. `kubectl apply -f src/main/kubernetes/cassandra-service.yaml`
2. `kubectl apply -f src/main/kubernetes/cassandra-statefulset.yaml`
3. `mvn clean package`
4. You must get cassandra ip , with `minikube service cassandra`, and then , using csql create a namespace:
```
create keyspace if not exists mykeyspace
    with durable_writes = true
	and replication = {
              'DC1-K8Demo': '3',
              'class': 'org.apache.cassandra.locator.NetworkTopologyStrategy'
     };
```

 
5. `kubectl apply -f src/main/kubernetes/mybooks-service.yaml`
6. `kubectl apply -f src/main/kubernetes/mybooks.yaml`
7. `minikube dashboard`

## Requests
```
export URL=`minikube service mybooks-service`
```
_Create_  
```
http POST $URL/book title=Titulo3 author=Autor language=SPANISH id=`uuidgen`
```
_Get All_
```
http $URL/books
```
_Get one_
```
http $URL/books/<id>
```
   
### Links
1. [Cassandra in Kubernetes](https://kubernetes.io/docs/tutorials/stateful-application/cassandra/)
2. [Big post on cassandra in kubernetes](https://blog.deimos.fr/2018/06/24/running-cassandra-on-kubernetes/)    
3. [Spring boot in kubernetes](https://www.baeldung.com/spring-boot-minikube)
4. [Kubernetes exposing ip](https://kubernetes.io/docs/tutorials/stateless-application/expose-external-ip-address/)
5. [Spring webflux](https://www.baeldung.com/spring-webflux)
6. [Spring cassandra](https://www.baeldung.com/spring-data-cassandra-tutorial)
7. [Spring data cassandra](https://docs.spring.io/spring-data/cassandra/docs/2.2.0.RC3/reference/html/)
8. [Cassandra CSQL Syntax](https://docs.datastax.com/en/archived/cql/3.3/cql/cql_reference/cqlCreateKeyspace.html)
9. [Como cambiar de container-runtime en minikube](https://cloudnative.mx/como-cambiar-de-container-runtime/)    
