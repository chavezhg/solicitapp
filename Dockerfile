# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM openjdk:8-jdk-slim
COPY "./target/solicitapp-0.0.1.jar" "solicitapp.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "solicitapp.jar"]