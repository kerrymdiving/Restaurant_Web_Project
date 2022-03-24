let data = []
const state = {
    menuOpen: null
}

fetch('http://localhost:8080/restaurants')
    .then(response => response.json())
    .then(_data => {
        data = _data
        render()
    })
    .catch(err => console.error(err))


    function getAddFormHtml() {
        return `
            <article>
                <form onsubmit="event.preventDefault();addRestaurant(this);">
                    <label>Restaurant Name</label>
                    <input name="name" required/>
                    <label>Image URL for Restaurant</label>
                    <input name="image" type="url" required/>
                    <button style="width: 13rem;">Add Restaurant</button>
                </form>
            </article>
        `
    }

    function render() {
        let content = data.map((restaurantData, i) => {
            return `
                <article  class="restaurant-card">
                    <div style="background-image: url('${restaurantData.imageURL}');"></div>
                    <restaurant-card-footer>
                        <h2>${restaurantData.name}</h2>
                        <button onclick="displayMenus(${i})">Menus</button>
                    </restaurant-card-footer>
                </article>
            `
        }).join("")

        content += getAddFormHtml()

        const appElements = document.getElementById('app')
        appElements.innerHTML = content

        if(state.menuOpen) {
            const modalContent = `
                    <section class="modal-bg">
                        <article>
                            ${state.menuOpen.map(menu => {
                                return `<h3>${menu.menu_title}</h3>`
                            }).join("")}
                            <button onclick="closeModal()">close</button>
                        <article>
                    </section>
            `
            const modalEl = document.getElementById('modal')
            modalEl.innerHTML = modalContent
        } else {
            const modalEl = document.getElementById('modal')
            modalEl.innerHTML = ""
        }
    }

    function addRestaurant(HTMLform) {
        const form = new FormData(HTMLform)
        const name = form.get('name')
        const image = form.get('image')
        fetch('/restaurants', {
        method: 'POST',
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({name, image})
        })
        .then(res => res.json())
        .then(restaurant => {
            data.push(restaurant)
            render()
        })
        .catch(console.error)
    }

    function displayMenus(index) {
        state.menuOpen = data[index].menus
        render()
    }

    function closeModal() {
        state.menuOpen = null
        render()
    }