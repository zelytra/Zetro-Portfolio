# Step 1: Build the application with Node.js (build-stage)
FROM node:latest AS build-stage
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# Step 2: Use the Nginx image with reduced privileges (rootless)
FROM nginxinc/nginx-unprivileged:stable-alpine AS production-build

COPY ./nginx.conf /etc/nginx/nginx.conf
COPY --from=build-stage /app/dist /etc/nginx/html

USER root

COPY ./env_runtime_editor.sh /env_runtime_editor.sh
RUN chmod +x /env_runtime_editor.sh

# Fix permissions so unprivileged user can write to these files
RUN chown -R nginx:nginx /etc/nginx/html && \
    chmod -R u+w /etc/nginx/html

USER nginx

EXPOSE 8080

ENTRYPOINT ["/env_runtime_editor.sh"]
