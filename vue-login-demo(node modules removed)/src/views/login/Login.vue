<template>
  <div>
    <el-card class="box-card">
      <h2>Sign in</h2>
      <el-form
          :model="ruleForm"
          status-icon
          :rules="rules"
          ref="ruleForm"
          label-position="left"
          label-width="70px"
          class="login-from"
      >
        <el-form-item label="Username" prop="uname">
          <el-input v-model="ruleForm.uname"></el-input>
        </el-form-item>
        <el-form-item label="Password" prop="password">
          <el-input
              type="password"
              v-model="ruleForm.password"
              autocomplete="off"
          ></el-input>
        </el-form-item>
      </el-form>
      <div class="btnGroup">
        <el-button
            type="primary"
            @click="submitForm('ruleForm')"
            v-loading="loading"
        >Sign in</el-button
        >
        <el-button @click="resetForm('ruleForm')">Reset</el-button>
        <router-link to="/register">
          <el-button style="margin-left: 10px">Register</el-button>
        </router-link>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      ruleForm: {
        uname: "",
        password: "",
      },
      rules: {
        uname: [
          { required: true, message: "Username cannot be empty!", trigger: "blur" },
        ],
        password: [
          { required: true, message: "Password cannot be empty!", trigger: "blur" },
        ],
      },
      loading: false, // Whether to show loading animation
    };
  },
  methods: {
    submitForm(formName) {
      // Verify if the username and password in the form are valid. They are required fields as defined in the rules above.
      this.$refs[formName].validate((valid) => {
        // After clicking login, start the loading animation on the login button
        this.loading = true;
        // If validation passes and both username and password are not empty, send a request to the backend login API
        if (valid) {
          let _this = this;
          // Use axios to send login information to the backend
          this.axios({
            url: "/api/user/login",               // Request URL
            method: "post",                       // Request method
            headers: {                            // Request headers
              "Content-Type": "application/json",
            },
            params: {                             // Request parameters
              uname: _this.ruleForm.uname,
              password: _this.ruleForm.password,
            },
          }).then((res) => { // Execute the code in this block when the backend response is received. 'res' is the response information returned by the backend.
            if (res.data.code === "0") {  // If the response code is 0, login is successful
              // Store user information in sessionStorage
              sessionStorage.setItem("userInfo", JSON.stringify(res.data.data));
              // Redirect to the homepage
              this.$router.push('/home');
              // Display the success message returned by the backend
              this.$message({
                message: res.data.msg,
                type: "success",
              });
            } else {  // If the response code is not 0, login failed
              // Display the failure message returned by the backend
              this.$message({
                message: res.data.msg,
                type: "warning",
              });
            }
            // Regardless of whether the response indicates success or failure, stop showing the loading animation on the login button after receiving the backend response
            _this.loading = false;
            console.log(res);
          });
        } else {  // If either the username or password is not filled in, show the required prompt directly without sending a request to the backend
          console.log("error submit!!");
          this.loading = false;
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>

<style>
/* Set the login panel to be centered, with a width of 400px */
.box-card {
  margin: auto auto;
  width: 400px;
}
/* Center the form within the login panel */
.login-from {
  margin: auto auto;
}

/* Set background color */
body {
  background: linear-gradient(to right, #dab37c, #d193da); /* Set gradient background color */
  height: 100vh; /* Set height to viewport height */
  display: flex; /* Use flex layout */
  justify-content: center; /* Center horizontally */
  align-items: center; /* Center vertically */
  margin: 0; /* Remove default body margin */
}
</style>
