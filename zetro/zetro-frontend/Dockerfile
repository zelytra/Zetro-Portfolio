# Step 1: Build the application with Node.js
FROM node:latest AS build-stage
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# Step 2: Use unprivileged Nginx for runtime
FROM nginxinc/nginx-unprivileged:stable-alpine AS production-build

USER root

# Create writable directory and copy build files there
RUN mkdir -p /usr/share/nginx/html
COPY --from=build-stage /app/dist /usr/share/nginx/html

# Set ownership for Nginx user
RUN chown -R nginx:nginx /usr/share/nginx/html

# Copy config and script
COPY ./nginx.conf /etc/nginx/nginx.conf
COPY ./env_runtime_editor.sh /env_runtime_editor.sh
RUN chmod +x /env_runtime_editor.sh

USER nginx
WORKDIR /usr/share/nginx/html

EXPOSE 8080

ENTRYPOINT ["/env_runtime_editor.sh"]
