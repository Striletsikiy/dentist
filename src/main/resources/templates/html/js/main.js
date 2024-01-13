const calendarForm = document.querySelector('.container-data form')
const prevBtn = document.querySelector('.prev')
const nextBtn = document.querySelector('.next')
const monthTitle = document.querySelector('.month');
const dateInput = document.querySelector('.container-data form input')
const dateOutput = document.querySelector('.output-dates');

let MONTH_INDEX = 0

const renderCalendar = function renderCalendarDays() {
    dateOutput.innerHTML = null
    let dates = []

    const today = moment().add('month', MONTH_INDEX); // поточна дата
    const firstDayOfMonth = moment(today).startOf('month'); // перший день поточного місяця
    const lastDayOfMonth = moment(today).endOf('month'); // останній день поточного місяця
    const daysInMonth = lastDayOfMonth.date(); // кількість днів у поточному місяці
    getUkrainianMonthName(firstDayOfMonth.format('MMMM'))
    let firstDayOfGrid = moment(firstDayOfMonth).startOf('week'); // перший день тижня, що міститься в сітці дат
    let lastDayOfGrid = moment(lastDayOfMonth).endOf('week'); // останній день тижня, що міститься в сітці дат

// якщо перше число місяця припадає на вівторок, то переносимо останній день попереднього місяця на понеділок
    if (firstDayOfMonth.day() === 2) {
        firstDayOfGrid = moment(firstDayOfMonth).subtract(1, 'week').startOf('week');
        lastDayOfGrid = moment(lastDayOfMonth).add(1, 'week').endOf('week');
    }

    const numDays = 42 ; // загальна кількість днів у сітці дат (42)

    for (let i = 0; i < numDays + 1; i++) {
        const day = moment(firstDayOfGrid).add(i, 'days');
        dates.push(day);
    }

    console.log('Sun Mon Tue Wed Thu Fri Sat');
    for (let i = 0; i < numDays; i++) {
            const date = dates[i];
            if(date.day() !== 0 && date.day() !== 6) {
                const isToday = date.isSame(today, 'day');
                const isCurrentMonth = date.isSame(firstDayOfMonth, 'month');
                const dateBlock = document.createElement('div');
                dateBlock.innerHTML = date.format('D')
                dateBlock.className = firstDayOfMonth.format('M') !== date.format('M') ? 'not-active date' : 'date'
                dateBlock.dataset.day = date.format('D.M.Y');

                dateBlock.addEventListener('click', event => {
                    dateInput.value = event.target.dataset.day
                    if(document.querySelector('.active')) {
                        document.querySelector('.active').classList.remove('active')
                    }
                    dateBlock.classList.remove('active')
                    event.target.classList.add('active')
                })
                dateOutput.appendChild(dateBlock);
            }
    }

}

renderCalendar()

prevBtn.addEventListener('click', () => {
    MONTH_INDEX--;
    renderCalendar()
})

nextBtn.addEventListener('click', () => {
    MONTH_INDEX++;
    renderCalendar()
})


function getUkrainianMonthName(monthName) {
    const lowerMonthName = monthName.toLowerCase()
    const months = {
        'january': 'Січень',
        'february': 'Лютий',
        'march': 'Березень',
        'april': 'Квітень',
        'may': 'Травень',
        'june': 'Червень',
        'july': 'Липень',
        'august': 'Серпень',
        'september': 'Вересень',
        'october': 'Жовтень',
        'november': 'Листопад',
        'december': 'Грудень'
    };

    // переводимо назву місяця в нижній регістр і замінюємо першу букву на велику
    console.log(months[lowerMonthName])
    monthTitle.innerHTML = months[lowerMonthName] || ''
}


