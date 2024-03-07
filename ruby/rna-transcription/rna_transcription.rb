class Complement
  NUCLEOTIDE_TRANSCIPTIONS = {
    'G' => 'C',
    'C' => 'G',
    'T' => 'A',
    'A' => 'U'
  }.freeze

  def self.of_dna(rna_sequence)
    rna_sequence
      .chars
      .map { |nucleotide| NUCLEOTIDE_TRANSCIPTIONS[nucleotide] }
      .join
  end
end
