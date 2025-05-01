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