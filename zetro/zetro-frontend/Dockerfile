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

EXPOSE 8080

CMD ["nginx", "-g", "daemon off;"]
