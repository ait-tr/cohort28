const BASE_URL = "https://jsonplaceholder.typicode.com";
const usersList = document.getElementById("usersList");
const usersList2 = document.getElementById("usersList2");
const userDetails = document.getElementById("userDetails");
const searchInput = document.getElementById("searchInput");
const users = [];

(async function fetchAndDisplayUsers() {
    try {
        const res = await fetch(`${BASE_URL}/users`);
        const users = await res.json();

        users.forEach((user) => {
            const li = document.createElement("li");
            li.innerText = user.name;
            usersList.appendChild(li);
        });

        let filteredUsers = users;
        displayUsers(users);

        searchInput.addEventListener('input', (e) => {
            const searchTerm = e.target.value.toLowerCase();
            
            filteredUsers = users.filter(user => {
                return user.name.toLowerCase().includes(searchTerm);
            });

            // filteredUsers = users.filter(user => 
            //     user.name.toLowerCase().includes(searchTerm)
            // );

            displayUsers(filteredUsers);
        })

    } catch (err) {
        console.log(err);
    }
})();

function displayUsers(users) {
    usersList2.innerHTML = "";
    
    users.forEach(user => {
            const li = document.createElement("li");
            li.innerText = user.name;
            li.addEventListener('click', () => displayUsersDetails(user))
            usersList2.appendChild(li);
        }
    );
}

function displayUsersDetails(user) {
    userDetails.innerHTML = '';

    const nameHeading = document.createElement('h2');
    nameHeading.innerHTML = user.name;

    const nickName = document.createElement('p');
    nickName.innerHTML = `<strong> Username: </strong> ${user.username}`;

    const email = document.createElement('p');
    email.innerHTML = `<strong> Email: </strong> ${user.email}`;

    const phone = document.createElement('p');
    phone.innerHTML = `<strong> Phone: </strong> ${user.phone}`;

    userDetails.append(nameHeading, nickName, email, phone);
}