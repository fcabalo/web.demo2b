git config --global user.name "username
git config --global user.email "email"
ssh-keygen -t rsa -b 4069 -C "email"
git init
git branch -a
git add .
git commit -m "message"
git remote add origin git@github.com:fcabalo/web.demo1.git
git push origin master
