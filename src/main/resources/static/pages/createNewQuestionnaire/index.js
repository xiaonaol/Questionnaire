onload = () => {
  $('#headerUsername').text($util.getItem('userInfo')[0].username)
  $('#headerDivB').text('创建调查问卷')

  $('#startTime').datetimepicker({
    language: 'zh-CN', // 显示中文
    format: 'yyyy-mm-dd', // 显示格式
    minView: "month", // 设置只显示到月份
    initialDate: new Date(), // 初始化当前日期
    autoclose: true, // 选中自动关闭
    todayBtn: true // 显示今日按钮
  })
  $('#endTime').datetimepicker({
    language: 'zh-CN', // 显示中文
    format: 'yyyy-mm-dd', // 显示格式
    minView: "month", // 设置只显示到月份
    initialDate: new Date(), // 初始化当前日期
    autoclose: true, // 选中自动关闭
    todayBtn: true // 显示今日按钮
  })
}

const handleCreateQuestionnaire = () => {
  let params = {
    createdBy: $util.getItem('userInfo')[0].username,
    questionnaireTitle: $('#surveyName').val(),
    questionnaireDescription: $('#surveyDescription').val(),
    startTime:$('#startTime').val(),
    endTime:$('#endTime').val(),
    status: "1",
    projectName: $util.getPageParam('questionnaireInfo').projectName,
    questionnaireType:$util.getPageParam('questionnaireInfo').questionnaireLeo
  }
  if (!params.questionnaireTitle) return alert('问卷名称不能为空！')
  if (!params.questionnaireDescription) return alert('问卷描述不能为空！')
  console.log(params);
  $.ajax({
    url: 'http://127.0.0.1:8089' + '/admin/addQuestionnaireInfo',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      if (res.code === '666'){

        alert('创建成功！请设置题目')
        location.href = '/pages/designQuestionnaire/index.html'
      }
      else console.log(res)
    }
  })
}
