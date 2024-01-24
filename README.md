# SocialCommerce

### docker-compose.yml 코드
```
version: '3'

services:
  nginx:
    build:
      context: .
      dockerfile: Dockerfile.nginx
    ports:
      - "80:80"
    depends_on:
      - redis
      - postgresql

  redis:
    build:
      context: .
      dockerfile: Dockerfile.redis
    environment:
      REDIS_PORT: 6379

  postgresql:
    build:
      context: .
      dockerfile: Dockerfile.postgresql
    environment:
      POSTGRES_DB: mydatabase
      POSTGRES_USER: myuser
      POSTGRES_PASSWORD: mypassword
    ports:
      - "5432:5432"

```
