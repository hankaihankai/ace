FROM java:8
VOLUME /tmp
RUN mkdir /app
Add eureka.jar /app/app.jar
ADDrunboot.sh /app/
RUN bash -c 'touch /app/app.jar'
WORKDIR /app
RUN chmod a+x runboot.sh
EXPOSE 8888
CMD /app/runboot.sh