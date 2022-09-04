# GIT записки


### Базовые команды:
```
git --version           -   выведет текущую версию установленного Git;

git config --global user.name "user_Home_PC"        - ГЛОБАЛЬНАЯ конфигурация: прописываем имя пользователя;
git config --global user.email "email@email.com"    - ГЛОБАЛЬНАЯ конфигурация: почту имя пользователя;

cd ..                   -   выйти из папки на 1 уровень вверх;
dir   (или)   ls        -   вывести на экран все файлы и папки (только НЕскрытые);
mkdir sample            -   создать папку "sample";
cd c:/sample/           -   перейти в куазанную директорию "sample";
git init                -   создать репозиторий в текущей папке;
ls -a                   -   вывести на экран скрытые файлы и папки;
cd .git                 -   зайти в скрытую папку ".git";
clear                   -   очистить экран;

git config user.name "user1"        - ЛОКАЛЬНАЯ конфигурация (для текущего проекта);
git config user.email "email1@email.com"    - ЛОКАЛЬНАЯ конфигурация (для текущего проекта);
Можно вручную прописать в файле "config" в директории ".git";

gitk                    - дефолтный UI -редактор, где можно посмотреть наши коммиты, ее нужно закрывать каждый раз;

git add index.html      - добавит в индекс все существующие файлы
git add *               - добавит в индекс все существующие файлы;
git add .               - добавит в индекс все файлы из текущей папки;

git commit -m "comment" - закомитили изменения. При этом "comment" - комментарии для комита;

git status              - Текущее состояние нашего текущего репозитория. Выведет например: _On branch master. nothing to commit, working tree clean_;

git log                                         - вывести на экран всю историю; 
git log --pretty=oneline                        - Вывести историю в одну строку, НО только огланиченное количество коммитов. (pretty -каким образом будем выводить нашу историю);
git log --pretty=oneline --max-count=3          - вывести последние 3 коммита;
git log --pretty=oneline --all                  - Вывести ВСЮ историю коммитов (pretty -каким образом будем выводить нашу историю);
git log --pretty=oneline --author="user"        - Вывести по автору;
git log --pretty=format:"%h - %s : %ad [ %an ]" - Вывести информацию о коммитах в указанном формате. Где:
                    %h  - короткий адрес нашего хэш;
                    %s  - комментарий к коммиту;
                    %ad - дата, когда был выполнен коммит;
                    %an - автор коммита;
git log --pretty=format:"%h - %s : %ad [ %an ]"  --date=short  - использовать сокращенную дату; 
git log --date=short                            - использовать сокращенную дату;
git log --pretty=oneline --all --date=short     - Вывести ВСЮ историю в ОДНУ строки, использовать СОКРАЩЕННУЮ дату;

git checkout            - на последнее закомиченное состояние. Лишние файлы будут удалены;
git checkout master     - переключится на последний коммит в ветке master;
git checkout 073db41    - переключится на коммит с заданным хэш (укороченный);
git checkout 073db41bfa2742b65819315a0cae10739fe3667d - то-же, но полный хэш;

git reset - Этой коммандой можно вернуть:
                состояние либо всей ветки, 
                либо отдельного коммита, 
                либо отдельного файла.
git reset HEAD test.txt  - вернуть файл "test.txt" в последнее сост-е, до внесения изм-й в рамках последнего коммита;
git reset 073db41 test.txt  - вернуть файл в состояние коммита "073db41", до внесения изм-й в файле "test.txt" в ;
git checkout test.txt       -возвр. сост. "test.txt " к последнему закомиченному (уничтожить все изменения);

git add test.txt    - добавить файл в индекс
git reset test.txt  - убрать файл из индекса

Создает новый коммит, в котором будут отменены наши изменения.
git revert HEAD             - удалить последний коммит (часто не хочет, поэтому след. команда, см. ниже!)
git revert HEAD --no-edit   - новый коммит, в котором будут удалены последние изменения, это в истории останется;
        revert - хотим вернуть состояние текущей ветки к такому месту,
        HEAD - это амый последний коммит в нашей ветке;
git revert 073db41bfa2742b65819315a0cae10739fe3667d --no-edit   - вернемся к коммиту, заданному хэшем;
git revert --abort          - отмена попытки возврата, соответственно исчезнет и возникший конфликт;
git revert --continue       - продолжить выполнение при возникновении конфликта;

git branch                  - вывести все ветки в локальном репозитории;
git checkout -b newBranch   - создать новую ветку "newBranch" и переключиться на нее;
            master          - обычно основная ветка (чистовик);
            dev             - ветка, в которой ведется вся разработка;
git checkout dev            - переключиться на ветку "dev";

Перейти в ту ветку, куда будем сливать. Затем указать ту ветку, которая будет слита в текущую:
git merge newBranch - слить ветку "newBranch" в текущую;
    Если предлагает комментарий по умолчанию - принято его и использовать. Для этого:
    "shift" + ":"  и вводим команду "wq" (записать и выйти)
git merge --abort          - отмена попытки мержа;


merg - будет использована та временная очередность, в которой коммитилось. независимо в какой именно ветке мы работали;
rebase - коммиты из указанной ветки блоком будут подтянуты и вставлены в конец текущей ветки. История коммитов НЕсохраняется;
 ИСПОЛЬЗОВАТЬ: рекомендовано только своих локальных веток.
 НЕ ИСПОЛЬЗ-ТЬ: нельзя для коллективных веток, т.к. затрем чьи-то коммиты.  
git rebase branchName       - присобачит ветку (т.е. все коммиты из ветки) "branchName" в конец текущей ветки;

```
### Удаленный репозиторий
```
git clone https://github.com/flyve-mdm/android-mdm-agent.git    - клонируем в текущую папку указанный репозиторий;

git remote add origin https://github.com/Yury-developer/t0.git    - команда добавит к нашему локальному репозиторию (проекту) удаленный (только созданный);
    Для github.com в качестве пароля использовать ТОКЕН (пароль не проглатывает);
git branch -M main                  - так рекомендовал GitHub;
git push -u origin main             - так рекомендовал GitHub;

git push --set-upstream origin nbnb - установить ветку по умолчанию

git push origin brabchName          - залить на удаленный ветку "brabchName" (в соответствующую одноименную). 
                                        Если ее нет в удаленном -то она создастся.
                                        
git pull origin main                - подтянуть изменения ветки "main" из удаленного репозитория.
git pull --rebase origin master     - вытянет всё из удаленного, после чего наложит поверх наши изменения, синхронизируя по времени.
 






git log --pretty --date=short --pretty=format:"%h - %s"
```

Удаленный репозиторий:
password:   использовать ТОКЕН!!!

#### push an existing repository from the command line
```
git remote add origin https://github.com/Yury-developer/t1.git
git branch -M main
git push -u origin main
```
#### create a new repository on the command line
```
echo "# t1" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/Yury-developer/t1.git
git push -u origin main
```






[Красивый терминал](https://ohmyz.sh/) - плагин - надстройка над обычным терминалом;

### commit - закомитить изменения;
`





```

```

```

```






`git config --global user.name "Ivan Ivanov"`

---
[Git - тренажер](https://learngitbranching.js.org/)

[Git - DevColibri](https://www.youtube.com/watch?v=en6gms6e54Q&list=PLIU76b8Cjem5B3sufBJ_KFTpKkMEvaTQR)

[YouTube канал - DevColibri **GIT**](https://www.youtube.com/watch?v=en6gms6e54Q&list=PLIU76b8Cjem5B3sufBJ_KFTpKkMEvaTQR)



