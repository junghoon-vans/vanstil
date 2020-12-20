---
title: "OSError: mysql_config not found"
linkTitle: "OSError: mysql_config not found"
date: 2020-11-16
type: docs
draft: false
weight: 3
---

에러 발생
---

```bash
$ pip3 install mysqlclient

Collecting mysqlclient==1.4.4
  Using cached https://files.pythonhosted.org/packages/4d/38/c5f8bac9c50f3042c8f05615f84206f77f03db79781db841898fde1bb284/mysqlclient-1.4.4.tar.gz
    Complete output from command python setup.py egg_info:
    /bin/sh: 1: mysql_config: not found
    /bin/sh: 1: mariadb_config: not found
    /bin/sh: 1: mysql_config: not found
    Traceback (most recent call last):
      File "<string>", line 1, in <module>
      File "/tmp/pip-build-s70o3t7s/mysqlclient/setup.py", line 16, in <module>
        metadata, options = get_config()
      File "/tmp/pip-build-s70o3t7s/mysqlclient/setup_posix.py", line 61, in get_config
        libs = mysql_config("libs")
      File "/tmp/pip-build-s70o3t7s/mysqlclient/setup_posix.py", line 29, in mysql_config
        raise EnvironmentError("%s not found" % (_mysql_config_path,))
    OSError: mysql_config not found

    ----------------------------------------
Command "python setup.py egg_info" failed with error code 1 in /tmp/pip-build-s70o3t7s/mysqlclient/
```

에러 해결
---

```bash
sudo apt-get install libmysqlclient-dev -y
```

> 추가 패키지 설치를 진행하면 해당 에러가 사라진다.
