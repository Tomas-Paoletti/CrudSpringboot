<script>
	//get all
	async function get() {
		const res = await fetch('http://localhost:8080/products');
		const data = await res.json();
		console.log(data);
	}
	//get by id or name
	async function getID() {
		const busqueda = document.querySelector('input[name="readinput"]').value;
		const res = await fetch('http://localhost:8080/products/' + busqueda);
		const data = await res.json();
		console.log(data);
	}

	//create
	async function create() {
		const nombre = document.getElementsByName('nameinput').value;
		const marca = document.getElementsByName('brandinput').value;
		const categoria = document.getElementsByName('categoryinput').value;
		const precio = document.getElementsByName('priceinput').value;

		fetch('http://localhost:8080/products/', {
			method: 'POST',
			headers: {
				Accept: 'application/json',
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({
				name: nombre,
				brand: marca,
				category: categoria,
				price: precio
			})
		});
	}

	async function deleteID() {
		const id = document.getElementById('deleteinput').value;
		const response = await fetch('http://localhost:8080/productos/' + id, {
			method: 'DELETE',
			headers: {
				'Content-Type': 'application/json'
			}
		});
		const jsonData = await response.json();
		console.log(jsonData);
	}
</script>

<main>
	<div class="nav">
		<h1 class="">CRUD</h1>
	</div>
	<div class="mainbody">
		<button class="get" on:click={get}>GET ALL</button>
		<div class="square">
			<h3>CREATE</h3>
			<input name="nameinput" type="text" placeholder="Enter name." />
			<input name="brandinput" type="text" placeholder="Enter brand." />
			<input name="categoryinput" type="text" placeholder="Enter category." />
			<input name="priceinput" type="text" placeholder="Enter price." />
			<button on:click={create}>CREATE.</button>
		</div>
		<div class="square">
			<h3>READ</h3>
			<input name="readinput" type="text" placeholder="Enter an ID." />
			<button on:click={getID}>READ.</button>
		</div>
		<div class="square">
			<h3>UPDATE</h3>
			<input name="nameinput" type="text" placeholder="Enter name." />
			<input name="brandinput" type="text" placeholder="Enter brand." />
			<input name="categoryinput" type="text" placeholder="Enter category." />
			<input name="priceinput" type="text" placeholder="Enter price." />
			<button on:click={create}>UPDATE.</button>
		</div>
		<div class="square">
			<h3>DELETE</h3>
			<input name="deleteinput" type="text" placeholder="Enter an ID." />
			<button on:click={deleteID}>DELETE.</button>
		</div>
	</div>
</main>

<style>
	* {
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}
	.nav {
		top: 0;
		display: flex;
		align-items: center;
		justify-content: center;
		height: 10vh;
	}
	.mainbody {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}
	.square {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		width: 50vw;
		height: auto;
		border: 1px solid black;
		margin: 1rem;
	}
	input {
		width: 50%;
		height: 2rem;
		margin: 0.2rem;
		text-align: center;
	}
	button {
		margin: 10px;
		width: 50%;
		height: 2rem;

		text-align: center;
	}
	.get {
		width: 50vw;
	}
</style>
