<template>
  <div class="tree-hollow">
    <header class="header">
      <h1 class="title">Supertree Hollow</h1>
      <nav class="nav-bar">
        <router-link to="/home" class="nav-item" active-class="active">Homepage</router-link>
        <router-link to="/search" class="nav-item" active-class="active">Search</router-link>
        <router-link to="/message" class="nav-item" active-class="active">Message</router-link>
        <router-link to="/me" class="nav-item" active-class="active">Me</router-link>
      </nav>
    </header>
    <main class="content">
      <div class="overlay"></div>
      <router-view></router-view>
    </main>
  </div>
</template>

<script>
export default {
  name: 'HomePage',
};
</script>

<style>
/* Global background */
body {
  background-color: #ffe0b2; /* Lighter shade of orange */
  margin: 0;
  font-family: Arial, sans-serif;
  height: 100vh;
  display: flex;
  flex-direction: column;
}

/* Supertree Hollow homepage style */
.tree-hollow {
  display: flex;
  flex-direction: column;
  flex: 1;
}

/* Header */
.header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  background-color: #4285f4; /* Google blue */
  padding: 10px 20px;
  color: white;
  display: flex;
  align-items: center;
  z-index: 1000;
}

/* Title */
.title {
  margin: 0;
  font-size: 24px;
  margin-right: 20px;
}

/* Navigation bar */
.nav-bar {
  display: flex;
}

.nav-item {
  padding: 10px 15px;
  color: white;
  text-decoration: none;
}

.nav-item:hover {
  background-color: #3c78d8; /* Darker blue on hover */
}

.active {
  background-color: #3367d6; /* Even darker blue for active item */
}

/* Main content area */
.content {
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px;
  margin-top: 60px; /* Adjust this value if header height changes */
  position: relative;
  width: 100%;
}

/* Semi-transparent white rectangle */
.overlay {
  position: absolute;
  top: 0;
  left: 12.5%; /* 12.5% from the left */
  width: 75%; /* Middle 75% */
  height: 100%;
  background-color: rgba(255, 255, 255, 0.5); /* Semi-transparent white */
  z-index: 500; /* Ensure it's below the header */
}

/* Supertree Hollow homepage style */
.tree-hollow {
  display: flex;
  flex-direction: column;
  height: 100vh;
  width: 180vh;
}
</style>
