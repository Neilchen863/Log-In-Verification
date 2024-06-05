module.exports = {
    lintOnSave: false, // Disable syntax checking
    // Enable proxy server
    devServer: {
        // The proxy server can forward requests with specified prefixes in the routes to the specified backend server
        proxy: {
            '/api': {
                target: 'http://localhost:8081',
                ws: true, // Whether to enable websockets
                changeOrigin: true,  // Whether to change the host when proxying
                pathRewrite: {
                    '^/api': '' // Here you can understand it as using '/api' to replace the address in the target, for example, if I want to call 'http://40.00.100.100:3002/user/add', I can directly write '/api/user/add'
                }
            }
        }
    }
}
