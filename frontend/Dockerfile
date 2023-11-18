# Use the official Node.js base image
FROM node:14-alpine

# Set the working directory
WORKDIR /app

# Copy the package.json and package-lock.json files into the container
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application files
COPY . .

# Expose the port that the application will run on
EXPOSE 3000

# Command to start the application
CMD ["npm", "start"]
