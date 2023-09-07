fetch('https://jsonplaceholder.typicode.com/users')
    .then(res => res.json())
    .then(users => {
        const userList = document.getElementById('userList');
        users.forEach(user => {
            const li = document.createElement('li');
            li.textContent = user.name;
            userList.appendChild(li);
        })
    })
    .catch(err => {
        const li = document.createElement('li');
        li.textContent = 'Пользователи не найдены: попробуйте повторить позднее';
        userList.appendChild(li);
    })
    .finally(console.log("Финиш"))