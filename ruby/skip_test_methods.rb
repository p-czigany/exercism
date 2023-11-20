file_path = ARGV[0]

if file_path.nil?
  puts 'Usage: ruby script.rb <file_path>'
  exit 1
end

File.open(file_path, 'r+') do |file|
  content = file.read
  content.gsub!(/^( *)(def\s+\w+)$(?!\s*#? *skip)/) { |match| "#{match}\n#{Regexp.last_match(1)}  skip" }
  file.rewind
  file.puts content
end
