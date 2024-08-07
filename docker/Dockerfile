FROM node:20.16.0

RUN npm install -g @angular/cli@latest

WORKDIR /
RUN mkdir angular-app
WORKDIR /angular-app

ENV APP_NAME 'meu-app'
ENV ROUTING 'true'
ENV STANDALONE 'false'
ENV STRICT 'true'
ENV STYLE 'scss'

CMD ng new $APP_NAME --routing=$ROUTING --standalone=$STANDALONE --strict=$STRICT --style=$STYLE \
    # && mv $APP_NAME/* \
    # && rm -rf $APP_NAME \
    && ng serve --host 0.0.0.0 --port 4200

EXPOSE 4200
