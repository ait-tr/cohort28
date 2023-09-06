const shoppingCart = {
    items: [], // массив товаров  item => name, price, quantity
    totalCost: 0, // итогова стоимость всех продуктов
    addItem(item) {
        const existingItem = this.items.find((e) => e.name === item.name);
        if (existingItem) {
            existingItem.quantity += item.quantity;
            existingItem.price =
                existingItem.price < item.price
                    ? item.price
                    : existingItem.price;
        } else {
            this.items.push(item);
        }
        this.updateTotalCost();
    },
    removeItem(itemName) {
        const index = this.items.findIndex((elem) => elem.name === itemName);
        if (index !== -1) {
            this.items.splice(index, 1);
            this.updateTotalCost();
        }
    },
    updateTotalCost() {
        this.totalCost = this.items.reduce((acc, item) => {
            return acc + item.price * item.quantity;
        }, 0);
    },
};

// const add = document.getElementById('add');
// '     555     '.trim() => '555'

// const add = document.getElementById('add');
add.onclick = addHandler;

// const stats = document.getElementById('stats');
stats.onclick = statsHandler;

// const container = document.getElementsByClassName('container')[0];

// console.log(container);

function statsHandler() {
    // Кол-во позиций;
    // Итоговая стоимость всех продуктов;
    // Итоговое кол-во всех продуктов;
    // Максимальная цена
    // Минимальная цена
    // Средняя цена
    if (shoppingCart.items.length) {
        const itemsQuantity = shoppingCart.items.length;

        // Данное решение не самое оптимальное
        // const itemsSortByPrice = shoppingCart.items.sort((a, b) => a.price - b.price);
        // const minPrice = itemsSortByPrice[0];
        // const maxPrice = itemsSortByPrice[itemsQuantity - 1];

        const minPrice = shoppingCart.items.reduce(
            (min, item) => (item.price < min ? item.price : min),
            itemsQuantity ? Number.MAX_VALUE : 0
        );
        const maxPrice = shoppingCart.items.reduce(
            (max, item) => (item.price > max ? item.price : max),
            0
        );

        const totalQuantity = shoppingCart.items.reduce(
            (total, item) => total + item.quantity,
            0
        );
        const totalCoast = shoppingCart.totalCost;

        const avgPrice = totalCoast / totalQuantity;

        statsOur.innerHTML = `
            <li>Number of items: ${itemsQuantity}</li>
            <li>Total Coast: ${totalCoast}</li>
            <li>Total Quantity: ${totalQuantity}</li>
            <li>Min Price: ${minPrice}</li>
            <li>Max Price: ${maxPrice}</li>
            <li>Avg Price: ${avgPrice}</li>
        `;
    } else {
        statsOur.innerHTML = "<p>The shopping cart is empty</p>";
    }
}

function addHandler() {
    if (
        productName.value.trim() &&
        price.value.trim() &&
        quantity.value.trim()
    ) {
        shoppingCart.addItem({
            name: productName.value.trim(),
            price: +price.value.trim(),
            quantity: +quantity.value.trim(),
        });

        productList.innerHTML = "";

        shoppingCart.items.forEach((e) => {
            const li = document.createElement("li");
            li.textContent = `
            Product name: ${e.name},
            Product price: ${e.price},
            Quantity of product: ${e.quantity}
        `;
            productList.appendChild(li);
        });

        productName.value = '';
        price.value = '';
        quantity.value = '';
    }
}