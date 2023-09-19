## Пример выполнения коммита

- с авто-индексацией изменений в отслеж.файлах

```bash
git commit -am 'update'Переключение на предыдущую ветку
```

```bash
git checkout -
```

## Просмотр журнала коммитов

```bash
git log
```

## Перезапись последнего коммита

не делать для публичных коммитов

```bash
git commit --amend -m 'новый комментарий'
git commit --amend --no-edit # не изменять комментарий
```

## Безопасная отмена коммита

```bash
git revert <commit_id>
```

## Удаление последних коммитов

```bash
git reset --hard HEAD~2 # удалить два последних коммита
```

## Просмотр коммитов

```bash
git show <commit_id>
git show # посмотреть последний
```

## Отмена незакоммиченных изменений

```bash
git checkout -f
```

## Коммит не на той ветке

```bash
git branch новая_ветка
git reset --hard HEAD~1
```

## Сохранение незакомиченных изменений

```bash
git stash # сохранить изменения
git stash pop # применить сохраненные изменения
```

## Переключение состояния раб/каталога (”машина времени”)

```bash
git checkout <commit_id>
```

## Просмотр изменений (разницы)

```bash
git diff # между раб/каталогом и индексом
git diff --staged # между индексом и последним коммитов
git diff HEAD # между раб/каталогом и последним коммитов
git diff master название_другой_ветки # просмотр разницы между ветками
```

## Список игнорируемых файлов/каталогов / файл `.gitignore`

**Пример**

```bash
# Compiled class file
*.class

# Log file
*.log

# BlueJ files
*.ctxty

# Mobile Tools for Java (J2ME)
.mtj.tmp/
```

## Файл `README.md`

**Пример**

```markdown
## Наш проект
### Участники
- nickname1
- nickname2
- nickname3
```