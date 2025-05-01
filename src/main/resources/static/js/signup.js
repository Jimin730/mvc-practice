function checkLoginId() {
    const loginId = document.getElementById('loginId').value;

    fetch('/api/member/checkLoginId', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ loginId: loginId })
    })
        .then(response => response.json())
        .then(data => {
            if (data.isDuplicate) {
                alert('이미 사용 중인 아이디입니다.');
            } else {
                alert('사용 가능한 아이디입니다.');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function checkNickName() {
    const nickName = document.getElementById('nickName').value;

    fetch('/api/member/checkNickName', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ nickName: nickName })
    })
        .then(response => response.json())
        .then(data => {
            if (data.isDuplicate) {
                alert('이미 사용 중인 닉네임입니다.');
            } else {
                alert('사용 가능한 닉네임입니다.');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

document.addEventListener('DOMContentLoaded', function() {
    const signupForm = document.getElementById('signupForm'); // 폼 ID로 가져옵니다.
    const loginIdInput = document.getElementById('loginId');
    const passwordInput = document.getElementById('password');
    const nameInput = document.getElementById('name');
    const nickNameInput = document.getElementById('nickName');

    // 오류 메시지 표시 공간 요소들을 가져옵니다.
    const loginIdError = document.getElementById('loginIdError');
    const passwordError = document.getElementById('passwordError');
    const nameError = document.getElementById('nameError');
    const nickNameError = document.getElementById('nickNameError');

    // 오류 메시지를 설정하는 함수
    function displayError(element, message) {
        element.textContent = message;
    }

    // 오류 메시지를 지우는 함수
    function clearError(element) {
        element.textContent = '';
    }

    // 폼 제출 이벤트를 감지합니다.
    signupForm.addEventListener('submit', function(event) {
        let isValid = true; // 폼 유효성 상태를 나타내는 플래그

        // 각 필드를 확인하고 오류 메시지를 표시합니다.
        if (loginIdInput.value.trim() === '') {
            displayError(loginIdError, '로그인 ID를 입력해주세요.');
            isValid = false;
        } else {
            clearError(loginIdError); // 입력 값이 있으면 오류 메시지 지움
        }

        if (passwordInput.value.trim() === '') {
            displayError(passwordError, '비밀번호를 입력해주세요.');
            isValid = false;
        } else {
            clearError(passwordError);
        }

        if (nameInput.value.trim() === '') {
            displayError(nameError, '이름을 입력해주세요.');
            isValid = false;
        } else {
            clearError(nameError);
        }

        if (nickNameInput.value.trim() === '') {
            displayError(nickNameError, '닉네임을 입력해주세요.');
            isValid = false;
        } else {
            clearError(nickNameError);
        }

        // 만약 하나라도 유효하지 않으면 폼 제출을 막습니다.
        if (!isValid) {
            event.preventDefault();
            // 첫 번째 오류 필드로 스크롤 이동 (선택 사항)
            const firstErrorField = signupForm.querySelector('.error-message:not(:empty)');
            if(firstErrorField) {
                firstErrorField.scrollIntoView({ behavior: 'smooth', block: 'center' });
            }
        } else {
            // 모든 필드가 유효하면 폼이 정상적으로 제출됩니다.
            console.log('폼 제출 성공');
            alert('회원가입이 완료되었습니다.');
        }
    });

    // 사용자가 필드에 입력하기 시작하면 오류 메시지를 지우는 이벤트 리스너 추가 (UX 개선)
    loginIdInput.addEventListener('input', function() { clearError(loginIdError); });
    passwordInput.addEventListener('input', function() { clearError(passwordError); });
    nameInput.addEventListener('input', function() { clearError(nameError); });
    nickNameInput.addEventListener('input', function() { clearError(nickNameError); });
});