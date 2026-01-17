document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.getElementById('loginForm');
    const usernameInput = document.getElementById('username');
    const passwordInput = document.getElementById('password');
    const loginBtn = document.getElementById('loginBtn');
    const messageDiv = document.getElementById('message');
    const usernameError = document.getElementById('usernameError');
    const passwordError = document.getElementById('passwordError');

    const API_BASE_URL = 'http://localhost:8080';

    loginForm.addEventListener('submit', async (e) => {
        e.preventDefault();

        // 重置状态
        resetErrors();
        messageDiv.textContent = '';
        messageDiv.className = 'message';

        // 获取输入值
        const username = usernameInput.value.trim();
        const password = passwordInput.value.trim();

        // 验证
        let isValid = true;
        if (!username) {
            usernameError.textContent = '用户名不能为空';
            isValid = false;
        }
        if (!password) {
            passwordError.textContent = '密码不能为空';
            isValid = false;
        }

        if (!isValid) return;

        // Loading 状态
        setLoading(true);

        try {
            // 发送请求
            const response = await fetch(`${API_BASE_URL}/api/login`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    username: username,
                    password: password
                })
            });

            // 处理响应
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }

            const result = await response.json();

            if (result.code === 0) {
                handleLoginSuccess(result.data, username);
            } else {
                messageDiv.textContent = result.message || '登录失败，请检查用户名或密码';
                messageDiv.classList.add('error');
            }

        } catch (error) {
            console.error('Login error:', error);
            messageDiv.textContent = '网络错误，请稍后重试';
            messageDiv.classList.add('error');
        } finally {
            // 恢复状态
            setLoading(false);
        }
    });

    function resetErrors() {
        usernameError.textContent = '';
        passwordError.textContent = '';
    }

    function setLoading(isLoading) {
        if (isLoading) {
            loginBtn.disabled = true;
            loginBtn.textContent = '登录中...';
        } else {
            loginBtn.disabled = false;
            loginBtn.textContent = '登录';
        }
    }

    function handleLoginSuccess(data, username) {
        // 存储 Token
        if (data && data.token) {
            localStorage.setItem('token', data.token);
            localStorage.setItem('username', username);
        }

        // 显示欢迎信息
        messageDiv.textContent = `欢迎，${username}! 登录成功`;
        messageDiv.classList.add('success');
    }
});
