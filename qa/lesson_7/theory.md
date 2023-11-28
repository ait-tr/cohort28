## Decision tables - Таблицы решений
одна из техник тест-дизайна методом черного ящика, которая относится к динамическому анализу. Используется в том случае, когда есть комбинация входных данных. Основной целью является проверка бизнес-логики и тестового покрытия

one of the black box test design techniques that relates to dynamic analysis. Used when there is a combination of input data. The main goal is to check business logic and test coverage

**Алгоритм работы с таблицами решений:**

- Определите все возможные условия(Conditions)
- Определите все соответствующие действия(Actions), которые могут произойти в системе
- Сгенерируйте все возможные комбинации условий; каждая отдельная комбинация формы - отдельный столбец в таблице решений
- Для каждой комбинации условий определите, какие действия должны выполняться, а какие - нет; заполните соответствующие поля в данном столбце ниже соответствующей комбинации условий
- Для каждого столбца составьте как минимум один контрольный пример, в котором выполняется заданная комбинация условий; тест должен проверить, выполняются ли соответствующие действия

- Define all possible Conditions
- Define all relevant Actions
- Generate all possible combinations of conditions; each individual shape combination is a separate column in the decision table
- For each combination of conditions, determine which actions should be performed and which should not; fill in the appropriate fields in this column below the appropriate combination of conditions
- For each column, create at least one test case in which the specified combination of conditions is true; the test should check if the appropriate actions are performed

[Презентация](https://docs.google.com/presentation/d/1X2AFW4ik4coNbsdNbLJOKXPa1iUiBR3S/edit?usp=sharing&ouid=116447005932578256378&rtpof=true&sd=true)

[Decision tables exercises](https://docs.google.com/spreadsheets/d/1Y7juU9kVFq_X7puM6WM9uFH3b-I5Df0b/edit?usp=sharing&ouid=116447005932578256378&rtpof=true&sd=true)

[TestNG documentation](https://testng.org/doc/documentation-main.html)


