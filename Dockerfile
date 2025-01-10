FROM mockoon/cli:9.1.0

# Copie o arquivo de configuração para dentro do container
COPY mockoon-environment.json /mockoon-environment.json

# Exponha a porta configurada no Mockoon
EXPOSE 3000

# Comando para iniciar o mock no container
CMD ["-d", "/mockoon-environment.json"]