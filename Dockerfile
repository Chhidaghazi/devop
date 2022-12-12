FROM openjdk:11
EXPOSE 8089
ADD ./target/ExamThourayaS2 ExamThourayaS2
ENTRYPOINT ["java","-jar","/ExamThourayaS2"]