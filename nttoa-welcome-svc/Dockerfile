FROM alpine:3.11.2 as builder
ARG APPLICATION_FAT_JAR=nttoa-welcome-api/target/nttoa-welcome-api-*.jar
COPY ${APPLICATION_FAT_JAR} /tmp/application.jar
RUN unzip -q /tmp/application.jar -d /tmp

FROM nexus.giffgaff.co.uk/java-base-image:8
ENV ENVIRONMENT=local
ENV JAVA_OPTS="-XshowSettings:vm -Dfile.encoding=UTF-8 -Djava.security.egd=file:/dev/./urandom"

COPY --from=builder /tmp/BOOT-INF/lib /app/lib
COPY --from=builder /tmp/META-INF /app/META-INF
COPY --from=builder /tmp/BOOT-INF/classes /app

CMD ["sh", "-c", "exec java $JAVA_OPTS -cp app:app/lib/* com.giffgaff.nttoawelcome.Application --spring.profiles.active=$ENVIRONMENT"]
