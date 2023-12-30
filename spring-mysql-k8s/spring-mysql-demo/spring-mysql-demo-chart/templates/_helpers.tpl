{{/* Define a helper to generate the full MySQL connection URL */}}
{{- define "my-spring-app.fullMYSQLConnectionURL" -}}
jdbc:mysql://{{ .Release.Name }}-mysql-service:3306/{{ .Values.mysql.databaseName }}?createDataBaseIfNotExist=true&characterEncoding=UTF-8&useUnicode=true&useSSL=false&allowPublicKeyRetrieval=true
{{- end -}}