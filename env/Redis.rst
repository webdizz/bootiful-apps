=========================================
Redis configuration
=========================================

Docker container configuration::

 docker pull dockerfile/redis
 docker run -d --name redis -p 6379:6379 dockerfile/redis redis-server /etc/redis/redis.conf --requirepass 123456

