FROM openjdk:8
ENV workdir=/root/wechatpush
COPY . ${workdir}
WORKDIR ${workdir}
EXPOSE 8081
CMD ["java","-jar","wechatpush.jar"]