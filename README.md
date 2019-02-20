# selenium_docker_grid

Docker setup from terminal:
docker run -d -P --name selenium-hub selenium/hub
docker run -d -P --link selenium-hub:hub selenium/node-chrome-debug
docker run -d -P --link selenium-hub:hub selenium/node-firefox-debug
