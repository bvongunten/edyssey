CREATE ROLE edyssey WITH LOGIN PASSWORD 'edyssey';

CREATE DATABASE edyssey OWNER edyssey;
GRANT ALL PRIVILEGES ON DATABASE edyssey TO edyssey;
